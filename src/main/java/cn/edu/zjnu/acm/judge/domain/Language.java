/*
 * Copyright 2014 zhanhb.
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
package cn.edu.zjnu.acm.judge.domain;

import cn.edu.zjnu.acm.judge.config.LanguageFactory;
import cn.edu.zjnu.acm.judge.exception.NoSuchLanguageException;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.Serializable;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/**
 *
 * @author zhanhb
 */
@Builder
@Value
@SuppressWarnings("FinalClass")
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private long extMemory;
    @NonNull
    private String name;
    @NonNull
    private String sourceExtension;
    @NonNull
    private String compileCommand;
    @Nullable
    private String executeCommand;
    @NonNull
    private String executableExtension;
    private long timeFactor;
    private long extTime;
    private String description;

    private Object readResolve() throws IOException {
        try {
            return LanguageFactory.getLanguage(id);
        } catch (NoSuchLanguageException ex) {
            throw new InvalidObjectException(ex.getMessage());
        }
    }

}
