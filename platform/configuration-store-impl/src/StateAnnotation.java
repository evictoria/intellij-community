// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.configurationStore;

import com.intellij.openapi.components.RoamingType;
import com.intellij.openapi.components.SettingsCategory;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;

@SuppressWarnings("ClassExplicitlyAnnotation")
public class StateAnnotation implements State {
  private final String name;
  private final Storage @NotNull [] storages;

  public StateAnnotation(@NotNull String name, @NotNull Storage storage) {
    this.name = name;
    storages = new Storage[]{storage};
  }

  @NotNull
  @Override
  public String name() {
    return name;
  }

  @Override
  public Storage @NotNull [] storages() {
    return storages;
  }

  @Override
  public boolean reloadable() {
    return false;
  }

  @Override
  public boolean defaultStateAsResource() {
    return false;
  }

  @Override
  public @NotNull String additionalExportDirectory() {
    return "";
  }

  @Deprecated
  @Override
  public String additionalExportFile() {
    return "";
  }

  @Override
  public Class<? extends NameGetter> presentableName() {
    return null;
  }

  @Override
  public boolean externalStorageOnly() {
    return false;
  }

  @Override
  public boolean reportStatistic() {
    return false;
  }

  @Override
  public boolean allowLoadInTests() {
    return false;
  }

  @Override
  public boolean useLoadedStateAsExisting() {
    return true;
  }

  @Override
  public boolean getStateRequiresEdt() {
    return false;
  }

  @Override
  public SettingsCategory category() {
    return SettingsCategory.OTHER;
  }

  @Override
  public RoamingType roamingType() {
    return RoamingType.DEFAULT;
  }

  @Override
  public Class<? extends Annotation> annotationType() {
    throw new UnsupportedOperationException("Method annotationType not implemented in " + getClass());
  }
}
