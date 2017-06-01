package modelos;

public class User {

		public enum Authority {
	
			ROLE_ADMIN,ROLE_USER
			
		}
	
		/**
		 * Username: Usuario de la aplicacion
		 */
		
		private String username;
		
		/**
		 * Tipo de autorización que tienen el usuario, que esta en el enum Authority
		 */
		private Authority authority;
		
		
		
		/**
		 * Constructor vacio para el Bean
		 */
		
		public User(){
			
		}
		
		/**
		 * Constructor con 2 parametros
		 * @param username: Usuario
		 * @param authority: Tipo de autorizacion.
		 */
		public User(String username,Authority authority){
			this.username=username;
			this.authority=authority;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public Authority getAuthority() {
			return authority;
		}

		public void setAuthority(Authority authority) {
			this.authority = authority;
		}
	
		
	}

