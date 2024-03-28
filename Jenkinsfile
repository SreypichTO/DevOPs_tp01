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
    }
}
