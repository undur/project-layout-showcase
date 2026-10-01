# ERProjectLayout showcase

Four small WebObjects applications that use [ERProjectLayout](https://github.com/undur/wonder-slim/tree/master/ERProjectLayout) in development and are built with [vermilingua](https://github.com/undur/vermilingua-maven-plugin).

| Project | Framework | Layout |
|---|---|---|
| WonderFluffy | Project Wonder | "Fluffy Bunny": `Sources`, `Components`, `Resources`, `WebServerResources`, declared in `build.properties` |
| WonderStandard | Project Wonder | the standard Maven layout: `src/main/java`, `src/main/components`, `src/main/woresources`, `src/main/webserver-resources` |
| PlainWOStandard | Plain WebObjects, no Wonder | the standard Maven layout |
| SimpleProject | wonder-slim | the standard Maven layout, with as little as possible |

Each application's Main page shows the bundle NSBundle found for it (`ERXProjectLayoutBundle` when run in development,
`NSLegacyBundle` when run as a built `.woa`), a value from its `Properties`, a stylesheet from its web server
resources, and of course all using a component template. Seeing all four means the application initialized propertly,
found its components, its WebObjects bundle resources and its web server resources.

## SimpleProject

A simple WO app that only has an `Application` class, `build.properties` and `pom.xml`, and a single `Main` component
to show resource loading works fine. Works everywhere, no IDE files and no Eclipse required. Nothing reads `.project`, `.classpath` or `.settings`.
Any IDE that runs `main()` with the Maven classpath, from the project folder, runs it in development.


```
pom.xml                                   ERExtensions, and vermilingua to build it
build.properties                          project.name, project.type and principalClass
src/main/java/simpleproject/Application.java   maps "/" to Main
src/main/java/simpleproject/Main.java
src/main/components/Main.wo/Main.html
```

## How it's wired

- **`build.properties`** says what the project is (`project.name`, `project.type`) and, for WonderFluffy, where its
  folders are (`dir.components`, `dir.woresources`, `dir.webserverResources`). vermilingua packages from the same
  folders, so development and the built application agree.
- **`Application`** registers ERProjectLayout's bundle factory in a static block, before `main()` touches NSBundle:
  `ERXProjectLayout.register()`. wonder-slim applications don't need this line; `ERXApplication` does it.
- **PlainWOStandard** has no Project Wonder, but depends on two of its small standalone jars: **ERFoundation**, whose
  NSBundle finds bundles in development and takes the bundle factory ERProjectLayout plugs in, and **ERWebObjects**,
  for jar frameworks. Both come before WebObjects on the classpath. Its launch configuration must set
  `-DNSProjectBundleEnabled=true`: project bundles are only used when that's set, and plain WebObjects doesn't set it
  (Project Wonder and wonder-slim set it when run from a project). It has to be a JVM argument, since NSBundle reads it
  before WebObjects reads its arguments.
- **`sun.security.action.GetPropertyAction`**, in each application: WebObjects' `NSTimeZone` uses this class, which the
  JDK removed in JDK 24. The replacement is the same as the one wonder-slim's ERExtensions includes.

## Notes

- The two Wonder applications use Project Wonder **7.5-SNAPSHOT** purely because Wonder 7.4 doesn't work without "Generate Bundles" which I don't have set. Wonder 7.4 _should_ work fine too if you flip on "Generate Bundles" in WOLips.

## Running

From Eclipse, run each project's launch configuration. From the command line:

```
cd WonderFluffy
mvn package
./target/WonderFluffy.woa/WonderFluffy -WOPort 1200
```
