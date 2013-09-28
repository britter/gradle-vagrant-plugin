/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.plugins.vagrant

import org.gradle.api.Project
import org.gradle.api.plugins.vagrant.validation.PrerequisitesValidator
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

class VagrantPluginSpec extends Specification {
    Project project
    PrerequisitesValidator prerequisitesValidator

    def setup() {
        project = ProjectBuilder.builder().build()
        prerequisitesValidator = Mock()
        project.prerequisitesValidator = prerequisitesValidator
    }

    def "Creates Vagrant default tasks"() {
        when:
            project.apply plugin: 'vagrant'
        then:
            project.tasks.findByName('vagrantDestroy') != null
            project.tasks.findByName('vagrantDestroy').commands == ['destroy', '--force']
            project.tasks.findByName('vagrantHalt') != null
            project.tasks.findByName('vagrantHalt').commands == ['halt']
            project.tasks.findByName('vagrantReload') != null
            project.tasks.findByName('vagrantReload').commands == ['reload']
            project.tasks.findByName('vagrantResume') != null
            project.tasks.findByName('vagrantResume').commands == ['resume']
            project.tasks.findByName('vagrantSshConfig') != null
            project.tasks.findByName('vagrantSshConfig').commands == ['ssh-config']
            project.tasks.findByName('vagrantStatus') != null
            project.tasks.findByName('vagrantStatus').commands == ['status']
            project.tasks.findByName('vagrantSuspend') != null
            project.tasks.findByName('vagrantSuspend').commands == ['suspend']
            project.tasks.findByName('vagrantUp') != null
            project.tasks.findByName('vagrantUp').commands == ['up']
    }
}
