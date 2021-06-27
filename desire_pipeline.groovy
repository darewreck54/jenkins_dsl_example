def gitUrl = 'https://github.com/alicommit-malp/jenkins_dsl_example'

for(i in 0..3) {
    job('test-job-' + i) {
        /*
        configure {
            def gblpass = it / 'buildWrappers'  / 'EnvInjectPasswordWrapper'  / 'passwordEntries' /
            injectGlobalPasswords(true)
            gblpass << 
            'EnvInjectPasswordEntry' {
                name("DEV_PWD")
                'password' "test123"
            }
        }
        */
        wrappers {
            credentialsBinding {
            usernamePassword('USER','MYPASSWORD', 'myCredentialId')
            }
        }
        environmentVariables {
            env('ONE', '1')
            propertiesFile('env.properties')
            keepBuildVariables(true)
        }
        scm {
            git(gitUrl)
        }
        triggers {
            scm('*/15 * * * *')
        }
        steps {
            shell {
                "echo 'run after Maven'"
                echo 'my password is : ' \$MYPASSWORD

            }
        }
    }
}
