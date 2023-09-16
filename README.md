[![Curseforge](http://cf.way2muchnoise.eu/full_877289_downloads.svg)](https://www.curseforge.com/minecraft/mc-mods/redirectionor) [![Curseforge](http://cf.way2muchnoise.eu/versions/For%20MC_877289_all.svg)](https://www.curseforge.com/minecraft/mc-mods/redirectionor)
# Redirector [Modern]
https://www.curseforge.com/minecraft/mc-mods/redirectionor
We have changed our name from redirectionor to redirector, because the redirection targets are not only about directions but all enum values now.

## Preface

In the well-known optimization mods for Minecraft, Sodium, Lithium or Phosphor, there is a common optimization concept: replacing references to element values in enum classes with static final field values references.

This technique aims to enhance performance by improving access speed and reducing unnecessary computations when frequently accessing the constants.

## Introduction

Redirectionor is the implementation of this concept to reduce the required memory of the game.

## What does Redirectionor optimize exactly?

It's quite wide. Nearly every Enum#values() call is redirected in this mod......

This implementation is not "thorough", but it is still quite impressive.

## Compatibility

Redirectionor is designed as compatible with every mod.

If you encounter any compatibility problem, pls create a new Issue on my GitHub global issue tracker https://github.com/MCTeamPotato/Kasualix-Issue-Tracker.

## Note

Redirectionor works on both the client and server and can be installed on servers without requiring clients to also have the mod.
# Issue Report
1.16.5+ : https://github.com/MCTeamPotato/Kasualix-Issue-Tracker

1.12.2-: https://github.com/Ecdcaeb/Redirectionor/issues
