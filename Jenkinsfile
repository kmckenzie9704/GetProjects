node {
	    stage('Checkout') { 
	         checkout scm 
	     } 
  
		stage('Initialize'){
			def dockerHome = tool 'myDocker' 
	        def mavenHome  = tool 'myMaven' 
	        env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}" 
		}

        stage('Build') { 
                sh "mvn -B -DskipTests clean package"
        }

		 stage('Create Docker Image') {
		   steps {
		      sh "docker build -t GetProjects:latest  -t GetProject --pull --no-cache ."
		    }
		}
}