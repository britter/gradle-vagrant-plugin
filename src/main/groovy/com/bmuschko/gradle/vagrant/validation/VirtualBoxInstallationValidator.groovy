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
package com.bmuschko.gradle.vagrant.validation

import com.bmuschko.gradle.vagrant.process.ExternalProcessExecutionResult
import com.bmuschko.gradle.vagrant.process.ExternalProgram
import groovy.util.logging.Slf4j

@Slf4j
class VirtualBoxInstallationValidator extends AbstractInstallationValidator {
    @Override
    ExternalProgram getExternalProgram() {
        ExternalProgram.VIRTUALBOX
    }

    @Override
    List<String> getExecutableOptions() {
        ['-v']
    }

    @Override
    void handleResult(ExternalProcessExecutionResult result) {
        if(result.isOK()) {
            log.info "Using VirtualBox ${result.text.trim()}."
        }
    }
}
