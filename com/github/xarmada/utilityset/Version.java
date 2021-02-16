package com.github.xarmada.utilityset;

public class Version {
  public int mainVersion;
  public int miniVersion;
  public int patchVersion;
  
  public Version(int one, int two, int three) {
    this.mainVersion = one;
    this.miniVersion = two;
    this.patchVersion = three;
  }
  
  public String getAsString() {
    return mainVersion + "." + miniVersion + "." + patchVersion;
  }
}
