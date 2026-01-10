pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/TON_COMPTE/Calculatrice.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy Nexus') {
            steps {
                sh 'mvn deploy'
            }
        }
    }
}
