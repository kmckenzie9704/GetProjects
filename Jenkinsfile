node {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
		stage('Initialize'){
		    env.PATH = "/var/lib/docker/bin:${env.PATH}"
		}
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
		 stage('Create Docker Image') {
		   steps {
		      sh "docker build -t GetProjects:latest  -t GetProject --pull --no-cache ."
		    }
		}
    }
}