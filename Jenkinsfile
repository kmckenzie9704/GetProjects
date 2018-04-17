node {
	    stage('Checkout') { 
	         checkout scm 
	     } 
  
		stage('Initialize'){
			def dockerHome = tool 'myDocker' 
	        def mavenHome  = tool 'myMaven' 
	        env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}" 
		}

        stage('Test') {
            steps {
                /* `make check` returns non-zero on test failures,
                * using `true` to allow the Pipeline to continue nonetheless
                */
                sh 'make check || true' 1
                junit '**/target/*.xml' 2
            }
        }

        stage('Build') { 
                sh "mvn -B -DskipTests clean package"
        }

		 stage('Copy WAR Image') {
		 		sh "ls -al"
		      sh "cp target/*.war /home/ken/eclipse-workspace/TimeManagement/TimeManagement/target"
		}

		 stage('Create Docker Image') {
		      sh "docker build -t getprojects:latest  -t getprojects --pull --no-cache ."
		}

}