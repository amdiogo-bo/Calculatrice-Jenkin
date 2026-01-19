pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy Nexus') {
            steps {
                sh 'mvn deploy -s /var/jenkins_home/.m2/settings.xml'
            }
        }
    }
}
