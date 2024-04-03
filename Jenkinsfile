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
        // stage('Bot-Notify') {
        //     steps {
        //         script {
        //             telegramSend(
        //                 message: "Jenkins pipeline build ",
        //                 chatId: "7053971638"
        //             )
        //         }
        //     }
        // }
    }
 post{
        success {
            sh '''#!/bin/bash

                L="----------------------------------------------------------"
                Log=$(git log -n 1 --pretty=format:"<b>COMMITER</b>: %cN %n<b>DATE</b>: %ci %n<b>MESSAGE</b>: %s")
                
                # Project=$(git remote -v | awk \'/^origin.*\\(fetch\\)$/ {print $2}\' | awk -F\'/\' \'{print $2}\' | awk -F\'.\' \'{print $1}\')
                
                Server="<b>Server</b>:Development"
                
                MSG="${L}%0A<b>PROJECT</b>: DMS Project %0A<b>APPLICATION</b>: Web %0A<b>STATUS</b>: Success%0A<b>VERSION</b>: ${BUILD_NUMBER}%0A${L}%0A${Log}%0A${L}%0A${Server}%0A${L}"
                
                if [ -z "${Log}" ];then
                    echo "String is Empty"
                    else
                    curl -s -X POST https://api.telegram.org/bot7053971638:AAETAJCinICayKn9Ie5TmjDp6cMNbVek5I4/sendMessage -d chat_id=1220773266 -d text="${MSG}" -d parse_mode="HTML"
                fi'''
        }
        failure {
            sh '''#!/bin/bash

                L="----------------------------------------------------------"
                Log=$(git log -n 1 --pretty=format:"<b>COMMITER</b>: %cN %n<b>DATE</b>: %ci %n<b>MESSAGE</b>: %s")
                
                # Project=$(git remote -v | awk \'/^origin.*\\(fetch\\)$/ {print $2}\' | awk -F\'/\' \'{print $2}\' | awk -F\'.\' \'{print $1}\')
                
                Server="<b>Server</b>:Development"
                
                MSG="${L}%0A<b>PROJECT</b>: PMS Project %0A<b>APPLICATION</b>: Web %0A<b>STATUS</b>: Failed%0A<b>VERSION</b>: ${BUILD_NUMBER}%0A${L}%0A${Log}%0A${L}%0A${Server}%0A${L}"
                
                if [ -z "${Log}" ];then
                    echo "String is Empty"
                    else
                    curl -s -X POST https://api.telegram.org/bot${BOT_TOKEN}/sendMessage -d chat_id=${CHAT_ID} -d text="${MSG}" -d parse_mode="HTML"
                fi'''
        }
    }

}
