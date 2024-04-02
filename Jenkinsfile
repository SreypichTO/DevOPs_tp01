pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git branch: 'mytp03' , url: 'https://github.com/SreypichTO/DevOPs_tp01.git'
            }
        }
        stage('Composer'){
            steps{
                sh 'composer install'
            }
        }
        stage('Copy .env'){
            steps{
                sh 'cp .env.example .env'
            }
        }
        stage('AppKey'){
            steps{
                sh 'php artisan key:generate'
            }
        }
        stage('npm'){
            steps{
                sh 'npm i'
                sh 'npm run build'
            }
        }
        stage('test'){
            steps{
                sh 'php artisan test'
            }
        }
        stage('Bot-Notify') {
            steps {
                script {
                    telegramSend(
                        message: "Jenkins pipeline build ${currentBuild.fullDisplayName} has finished with ${currentBuild.currentResult}",
                        chatId: "7053971638"
                    )
                }
            }
        }
    }
    post {
        success {
            emailext (
                to: 'sreypichdarani2003@gmail.com', 
                subject: 'Pipeline Successful',
                body: 'Your Jenkins Pipeline has completed successfully.',
                mimeType: 'text/html'
            )
        }
        failure {
            emailext (
                to: 'sreypichdarani2003@gmail.com', 
                subject: 'Pipeline Failed',
                body: 'Your Jenkins Pipeline has failed. Please investigate.',
                mimeType: 'text/html'
            )
        }
    }
}
