def gitUrl = 'https://github.com/alicommit-malp/jenkins_dsl_example'

for(i in 0..3) {
    job('test-job-' + i) {
        scm {
            git(gitUrl)
        }
        triggers {
            scm('*/15 * * * *')
        }
        steps {
            shell "echo 'run after Maven'"
        }
    }
}
