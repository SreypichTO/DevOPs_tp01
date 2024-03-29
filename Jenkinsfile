pipeline {
    agent any
    tools {
        gradle 'Gradle8.7'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'midterm' , url: 'https://github.com/SreypichTO/DevOPs_tp01.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'gradle build'
            }
        }
        
        stage('Run') {
            steps {
                sh 'gradle bootRun'
            }
        }
    }
    post {
        success {
            emailext (
                to: 'mailtrap', 
                subject: 'Pipeline Successful',
                body: 'Your Jenkins Pipeline has completed successfully.',
                mimeType: 'text/html'
            )
        }
        failure {
            emailext (
                to: 'mailtrap', 
                subject: 'Pipeline Failed',
                body: 'Your Jenkins Pipeline has failed. Please investigate.',
                mimeType: 'text/html'
            )
        }
    }
}

