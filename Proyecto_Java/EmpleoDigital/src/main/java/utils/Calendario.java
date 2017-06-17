package utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import dao.*;
import modelos.*;

public class Calendario {

	
	private ApplicationContext ctx;
	
	public Calendario(ApplicationContext ctx){
		this.ctx=ctx;
	}
	
	public Date getFechaFin(Formacion f){
		
		ArrayList<Date> arrayFechas = getArrayFechas(f.getFechaInicio());
		Date fechaFin = f.getFechaInicio();
		/**
		 * Insercion de los DAOs
		 */
		DAOModuloFormacion daomf = (DAOModuloFormacion)ctx.getBean("daoModuloFormacion");
		DAOVacaciones daov = (DAOVacaciones)ctx.getBean("daoVacaciones");
		DAOFiestaNacional daofn = (DAOFiestaNacional)ctx.getBean("daoFiestaNacional");
		DAOFiestaRegional daofr = (DAOFiestaRegional)ctx.getBean("daoFiestaRegional");
		DAOFiestaLocal daofl = (DAOFiestaLocal)ctx.getBean("daoFiestaLocal");


		/**
		 * Bucle iterativo para recuperar las jornadas de los Módulos que pertenecen a la formación dada.
		 */
		int jornadasTotales = 0;
		List<ModuloFormacion> listaModulos = daomf.listarByIdFormacion(f.getId());
		for(ModuloFormacion mf: listaModulos){
			jornadasTotales = jornadasTotales + mf.getJornadas();
		}
		
		/**
		 * Generamos un List de las vacaciones que tengan el idFormacion dado
		 */
		List<Vacaciones> vacaciones;
		vacaciones = daov.listarByIdFormacion(f.getId());
		
		/**
		 * Generamos un List de Fiestas Nacionales
		 */
		List<FiestaNacional> fiestasNacional = daofn.listar();
		
		
		/**
		 * Generamos un List de Fiestas Regionales pertenecientes a la comunidad de nuestra formacion
		 */
		List<FiestaRegional> fiestasRegional =  daofr.listarByIdFormacion(f.getId());
		
		/**
		 * Generamos un List de Fiestas Locales que correspondan con la localidad de nuestra formación
		 */
		List<FiestaLocal> fiestasLocal = daofl.listarByIdFormacion(f.getId());
		
				
		Calendar calendar = Calendar.getInstance();
		
		/**
		 * Variables intermedias utilizadas en la función:
		 * 		ordenActual indica el módulo cuyo orden estamos colocando en el calendario
		 * 		jActual indica la jornada actual que estamos colocando, cuando llegue a las jornadas totales abremos acabado
		 * 		posCalendario indica la posicion del calendario en la que nos encontramos
		 * 		ultimoCambio es una variable intermedia que nos servirá para colocar los módulos,
		 * 					 en función de las jornadas que tenga el modulo, de las jornadas totales
		 * 					 y de la jornada actual, así como del orden por el que vayamos
		 * 		ordenOff dirá si estamos introduciendo un módulo con orden o con fecha (true ==> fecha; false ==> orden)
		 */
		int ordenActual = 1, jActual = 1, posCalendario = 0, ultimoCambio = 0;
		boolean ordenOff = false;
		/**
		 * BUCLE PRINCIPAL QUE RELLENARÁ EL CALENDARIO
		 */
		while(jActual <= jornadasTotales){
			
			
			/**
			 * En esta variable indicaremos si en la fecha que nos encontramos hay módulo o no.
			 * 	Si al final de la comprobación de los fines de semana y vacaciones la variable sigue a TRUE,
			 * será porque ahí hay que insertar un módulo, y pasaremos a dicha parte del programa.
			 */
			boolean moduloOk = true;
			
			//Comprobamos el día de la semana y si es o no fin de semana 
			calendar.setTime(arrayFechas.get(posCalendario));
			int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
			
			//Prioridad 1: Fines de semana; si es fin de semana, no será nada de lo demás.
			if(diaSemana == 7 || diaSemana == 1){
				moduloOk = false;
			}
			//Segunda prioridad: si no es día de la semana, comprobamos vacaciones y festivos
			else{
				//Comprobamos si en la base de datos la fecha coincide con alguna de las vacaciones
				for(Vacaciones v: vacaciones){
					if(arrayFechas.get(posCalendario).compareTo(v.getFecha()) == 0){
						moduloOk = false;
					}
				}
				//Comprobamos si en la base de datos alguna fiesta nacional coincide con la fecha dada
				for(FiestaNacional fn: fiestasNacional){
					if(arrayFechas.get(posCalendario).compareTo(fn.getFecha()) == 0){
						moduloOk = false;
					}
				}
				//Comprobamos si en la base de datos alguna fiesta regional coincide con la fecha dada
				for(FiestaRegional fr: fiestasRegional){
					if(arrayFechas.get(posCalendario).compareTo(fr.getFecha()) == 0){
						moduloOk = false;
					}
				}
				//Comprobamos si en la base de datos alguna fiesta local coincide con la fecha dada
				for(FiestaLocal fl: fiestasLocal){
					if(arrayFechas.get(posCalendario).compareTo(fl.getFecha()) == 0){
						moduloOk = false;
					}
				}
			}
			//Si no es fin de semana, ni festivo, comprobaremos a qué módulo corresponde, y si hay o no tutoría
			if(moduloOk){
				Date fechaInicio = null;
				for(ModuloFormacion mf: listaModulos){
					if(mf.getFechaInicio() == null){
						fechaInicio = new Date(90,1,1);
					}else{
						fechaInicio = mf.getFechaInicio();
					}
					if((fechaInicio.compareTo(arrayFechas.get(posCalendario)) == 0) || ordenOff){
						if(mf.getOrden()==ordenActual){
							mf.setOrden(0);
						}
						
						if(fechaInicio.compareTo(arrayFechas.get(posCalendario)) == 0){
							ultimoCambio = jActual;
						}
						if(((mf.getJornadas() + ultimoCambio) - jActual) > 0){
							if((((mf.getJornadas() + ultimoCambio) - jActual) == 1) && (mf.getHorasTutorias() != 0)){
							}
							break;
						}
						else if(((mf.getJornadas() + ultimoCambio) - jActual) == 0){
							ultimoCambio = jActual;
							ordenOff = false;
							break;
						}
						
					}
					else{
						if((ordenActual == mf.getOrden()) && (mf.getFechaInicio() == null)){
							if(((mf.getJornadas() + ultimoCambio) - jActual) > 0){
								if((((mf.getJornadas() + ultimoCambio) - jActual) == 1) && (mf.getHorasTutorias() != 0)){
								}
								break;
							}
							else if(((mf.getJornadas() + ultimoCambio) - jActual) == 0){
								ordenActual++;
								ultimoCambio = jActual;
								break;
							}
						}
					}
				}
				jActual++;
			}	
			fechaFin = arrayFechas.get(posCalendario);

			posCalendario++;
		}
				
		return fechaFin;
	}
	public ArrayList<Integer> getCalendario(Formacion f){
		
		/**
		 * Insercion de los DAOs
		 * 
		 */
		DAOModuloFormacion daomf = (DAOModuloFormacion)ctx.getBean("daoModuloFormacion");
		DAOVacaciones daov = (DAOVacaciones)ctx.getBean("daoVacaciones");
		DAOFiestaNacional daofn = (DAOFiestaNacional)ctx.getBean("daoFiestaNacional");
		DAOFiestaRegional daofr = (DAOFiestaRegional)ctx.getBean("daoFiestaRegional");
		DAOFiestaLocal daofl = (DAOFiestaLocal)ctx.getBean("daoFiestaLocal");
	
		ArrayList<Date> arrayFechas = getArrayFechas(f.getFechaInicio());
		
		ArrayList<Integer> arrayCalendario = new ArrayList<Integer>();
		
		
		/**
		 * Bucle iterativo para recuperar las jornadas de los Módulos que pertenecen a la formación dada.
		 */
		int jornadasTotales = 0;
		List<ModuloFormacion> listaModulos = daomf.listarByIdFormacion(f.getId());
		for(ModuloFormacion mf: listaModulos){
			jornadasTotales = jornadasTotales + mf.getJornadas();
		}
		
		/**
		 * Generamos un List de las vacaciones que tengan el idFormacion dado
		 */
		List<Vacaciones> vacaciones;
		vacaciones = daov.listarByIdFormacion(f.getId());
		
		/**
		 * Generamos un List de Fiestas Nacionales
		 */
		List<FiestaNacional> fiestasNacional = daofn.listar();
		
		
		/**
		 * Generamos un List de Fiestas Regionales pertenecientes a la comunidad de nuestra formacion
		 */
		List<FiestaRegional> fiestasRegional =  daofr.listarByIdFormacion(f.getId());
		
		/**
		 * Generamos un List de Fiestas Locales que correspondan con la localidad de nuestra formación
		 */
		List<FiestaLocal> fiestasLocal = daofl.listarByIdFormacion(f.getId());
		
				
		Calendar calendar = Calendar.getInstance();
		
		/**
		 * Variables intermedias utilizadas en la función:
		 * 		ordenActual indica el módulo cuyo orden estamos colocando en el calendario
		 * 		jActual indica la jornada actual que estamos colocando, cuando llegue a las jornadas totales abremos acabado
		 * 		posCalendario indica la posicion del calendario en la que nos encontramos
		 * 		ultimoCambio es una variable intermedia que nos servirá para colocar los módulos,
		 * 					 en función de las jornadas que tenga el modulo, de las jornadas totales
		 * 					 y de la jornada actual, así como del orden por el que vayamos
		 * 		ordenOff dirá si estamos introduciendo un módulo con orden o con fecha (true ==> fecha; false ==> orden)
		 */
		int ordenActual = 1, jActual = 1, posCalendario = 0, ultimoCambio = 0;
		boolean ordenOff = false;
		/**
		 * BUCLE PRINCIPAL QUE RELLENARÁ EL CALENDARIO
		 */
		Calendario calendario = new Calendario(ctx);
		//while(jActual <= jornadasTotales){
		while((arrayFechas.get(posCalendario).compareTo(calendario.getFechaFin(f))) < 0){
			
			/**
			 * En esta variable indicaremos si en la fecha que nos encontramos hay módulo o no.
			 * 	Si al final de la comprobación de los fines de semana y vacaciones la variable sigue a TRUE,
			 * será porque ahí hay que insertar un módulo, y pasaremos a dicha parte del programa.
			 */
			boolean moduloOk = true;
			
			//Comprobamos el día de la semana y si es o no fin de semana 
			calendar.setTime(arrayFechas.get(posCalendario));
			int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
			
			//Prioridad 1: Fines de semana; si es fin de semana, no será nada de lo demás.
			if(diaSemana == 7 || diaSemana == 1){
				arrayCalendario.add(posCalendario, -2);
				moduloOk = false;
			}
			//Segunda prioridad: si no es fin de semana, comprobamos vacaciones y festivos
			else{
				//Comprobamos si en la base de datos la fecha coincide con alguna de las vacaciones
				for(Vacaciones v: vacaciones){
					if(arrayFechas.get(posCalendario).compareTo(v.getFecha()) == 0){
						arrayCalendario.add(posCalendario, -1);
						moduloOk = false;
						break;
					}
				}
				//Comprobamos si en la base de datos alguna fiesta nacional coincide con la fecha dada
				for(FiestaNacional fn: fiestasNacional){
					if(arrayFechas.get(posCalendario).compareTo(fn.getFecha()) == 0){
						arrayCalendario.add(posCalendario, -1);
						moduloOk = false;
						break;
					}
				}
				//Comprobamos si en la base de datos alguna fiesta regional coincide con la fecha dada
				for(FiestaRegional fr: fiestasRegional){
					if(arrayFechas.get(posCalendario).compareTo(fr.getFecha()) == 0){
						arrayCalendario.add(posCalendario, -1);
						moduloOk = false;
						break;
					}
				}
				//Comprobamos si en la base de datos alguna fiesta local coincide con la fecha dada
				for(FiestaLocal fl: fiestasLocal){
					if(arrayFechas.get(posCalendario).compareTo(fl.getFecha()) == 0){
						arrayCalendario.add(posCalendario, -1);
						moduloOk = false;
						break;
					}
				}
			}
			//Si no es fin de semana, ni festivo, comprobaremos a qué módulo corresponde, y si hay o no tutoría
			System.out.println(moduloOk);
			if(moduloOk){
				Date fechaInicio = null;
				System.out.println(arrayFechas.get(posCalendario));
				for(ModuloFormacion mf: listaModulos){
					System.out.println(mf);
					if(mf.getFechaInicio() == null){
						fechaInicio = new Date(1000);
					}else{
						fechaInicio = mf.getFechaInicio();
					}
					if((fechaInicio.compareTo(arrayFechas.get(posCalendario)) == 0) || ordenOff){
						if(mf.getOrden()==ordenActual){
							mf.setOrden(0);
						}
						if(fechaInicio.compareTo(arrayFechas.get(posCalendario)) == 0){
							ultimoCambio = jActual;
						}
						if(((mf.getJornadas() + ultimoCambio) - jActual) > 0){
							if((((mf.getJornadas() + ultimoCambio) - jActual) == 1) && (mf.getHorasTutorias() != 0)){
								arrayCalendario.add(posCalendario, 0);
							}
							break;
						}
						else if(((mf.getJornadas() + ultimoCambio) - jActual) == 0){
							arrayCalendario.add(posCalendario, mf.getId());
							ultimoCambio = jActual;
							ordenOff = false;
							break;
						}
						
					}
					else{
						if((ordenActual == mf.getOrden()) && (mf.getFechaInicio() == null)){
							if(((mf.getJornadas() + ultimoCambio) - jActual) > 0){
								arrayCalendario.add(posCalendario, mf.getId());
								if((((mf.getJornadas() + ultimoCambio) - jActual) == 1) && (mf.getHorasTutorias() != 0)){
									arrayCalendario.add(posCalendario, 0);
								}
								break;
							}
							else if(((mf.getJornadas() + ultimoCambio) - jActual) == 0){
								arrayCalendario.add(posCalendario, mf.getId());
								ordenActual++;
								ultimoCambio = jActual;
								break;
							}
						}
					}
				}
				jActual++;
			}
			System.out.println(arrayCalendario);
			posCalendario++;
		}
		return arrayCalendario;
	}
	
	
	
	
	public ArrayList<Date> getArrayFechas(Date fechaInicio){
		//Creamos el ArrayList de Date donde almacenaremos las fechas
		ArrayList<Date> arrayFechas = new ArrayList<Date>();
		
		arrayFechas.add(fechaInicio);//Añadimos la primera fecha, la fecha de inicio de la formación
		
		
		//Creamos el objeto Calendar
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fechaInicio);
		calendario.add(Calendar.DATE, 1); //Sumamos uno al día
		Date fechaNueva = calendario.getTime();
		arrayFechas.add(fechaNueva);
		
		//Bucle para hacerlo 364 veces más
		for (int i = 0; i <364; i++){
			calendario.setTime(fechaNueva);
			calendario.add(Calendar.DATE, 1); //Sumamos uno al día
			fechaNueva = calendario.getTime();
			arrayFechas.add(fechaNueva);	
		}
		
		return arrayFechas;
	}
	public ApplicationContext getCtx() {
		return ctx;
	}
	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}
}
