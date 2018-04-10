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
		      sh "docker build -t getprojects:latest  -t getprojects --pull --no-cache ."
		}

		 stage('Copy WAR Image') {
		 		sh "ls -al"
		 		sh "whoami"
		      sh "cp -f target/*.war /opt/target/"
		}
}