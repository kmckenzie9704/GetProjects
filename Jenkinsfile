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

		 stage('Copy WAR Image') {
		 		sh "ls -al"
		      sh "cp target/*.war /home/ken/eclipse-workspace/TimeManagement/TimeManagement/target"
		}

		 stage('Create Docker Image') {
		      sh "docker build -t getprojects:latest  -t getprojects --pull --no-cache ."
		}

}