pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'test_gradle' , url: 'https://github.com/SreypichTO/DevOPs_tp01.git'
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
}
