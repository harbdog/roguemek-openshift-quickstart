/**
 * You can make customizations directly to this configuration script, webapp restart required if running.
 */
roguemek {
	users {	// If no users are predefined, the first user that registers will be an admin user
//		admin {		// optional super user administrator user to create during init
//			username = "admin@roguemek.com"
//			callsign = "SuperUser"
//			password = "AdminAdmin"
//		}
//		demo {		// optional initial demo user to create during init
//			username = "demo@roguemek.com"
//			callsign = "DemoUser"
//			password = "DemoDemo"
//		}
	}
	server {
		headerMessage = "This is an OpenShift RogueMek server"	// the message at the top of the root index page
		preloadMaps = false	// set true to have all maps loaded during next server init (may take several minutes more)
		
		// hpgTransport: some servers do not support websocket connections, set this to "long-polling" to prevent clients from trying websocket
		hpgTransport = "long-polling"
	}
	registration {
		// Any new user attempting to register can be enabled by setting newUserEnable to one of the following settings:
		//  "email"		// (recommended) confirmation email is sent to registered email address with a link to enable new accounts
		//				// NOTE: "email" requires the grails mail settings to be provided or it will fail
		//  "public"	// registered accounts are automatically enabled
		//  "private"	// registered accounts must be enabled by an administrator
		//	"disable"	// only administrators can create accounts
		newUserEnable = "public"
	}
	game {
		settings {
			maxUserUnits = 12		// maximum units per user in a game
			maxBattleUnits = 24		// maximum units total in a game
			userStagingLimit = 3	// maximum staging battles per user
		}
	}
	external {
		settings {
			externalUnitLink = "http://www.sarna.net/wiki/"
		}
	}
}

dataSource {
	// default to local h2 database
	driverClassName = "org.h2.Driver"
    username = "sa"
	password = ""	// h2 password not necessary since dbconsole requires ROOT role login to access
    url = "jdbc:h2:${System.env.OPENSHIFT_DATA_DIR}/roguemekdb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"	// default h2 db location is ~ user home
	
//	Example connection to a MySQL server using OS environment variables for the values
//  NOTE: Don't forget to uncomment hibernate.query.substitutions below
//	driverClassName = "com.mysql.jdbc.Driver"
//	username = System.env.OPENSHIFT_MYSQL_DB_USERNAME
//	password = System.env.OPENSHIFT_MYSQL_DB_PASSWORD
//  url = "jdbc:mysql://"+System.env.OPENSHIFT_MYSQL_DB_HOST+":"+System.env.OPENSHIFT_MYSQL_DB_PORT+"/"+System.env.OPENSHIFT_APP_NAME

//	Example connection to a Postgres server using OS environment variables for the values:
//	driverClassName = "org.postgresql.Driver"
//	username = System.env.OPENSHIFT_POSTGRESQL_DB_USERNAME
//	password = System.env.OPENSHIFT_POSTGRESQL_DB_PASSWORD
//	url = "jdbc:postgresql://"+System.env.OPENSHIFT_POSTGRESQL_DB_HOST+":"+System.env.OPENSHIFT_POSTGRESQL_DB_PORT+"/"+System.env.OPENSHIFT_APP_NAME

//  Debugging options:
//	logSql: true
//	formatSql: true
}

//  MySQL won't work unless its rand() function is referenced instead of random()
//hibernate.query.substitutions = 'random=rand()'

grails {
	mail {
//      Setup the mail server connection information to support email confirmation for registration and password resets
//		host = "smtp.gmail.com"
//		port = 465
//		username = "username@gmail.com"
//		password = "PASSWORD"
//		props = ["mail.smtp.auth":"true",
//				 "mail.smtp.socketFactory.port":"465",
//				 "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
//				 "mail.smtp.socketFactory.fallback":"false"]
	}
	plugin {
		atmosphere_meteor {
			plugin {
				initializeBeans {
					delay = 10000  // milliseconds to delay initialization
					period = 5000  // milliseconds to retry initialization based on servletContext readiness (e.g. waiting finish all BootStrap activities)
					attempts = 200 // number of attempts the TimerTask will make before quitting
				}
			}
		}
	}
}

grails.plugin.springsecurity.secureChannel.definition = [
	//'/**':    'REQUIRES_SECURE_CHANNEL'	// Require HTTPS for all pages
]

log4j.external = {
	//trace "org.hibernate.type.descriptor.sql.BasicBinder"
	//debug "org.hibernate.SQL"
	//debug "roguemek"
}
