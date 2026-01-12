pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/amdiogo-bo/Calculatrice-Jenkin.git'

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
