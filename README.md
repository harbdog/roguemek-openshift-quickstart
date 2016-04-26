## About
This is an OpenShift quickstart repository containing action hooks to automatically download, setup, and deploy the [RogueMek](https://github.com/harbdog/roguemek) application during the build process.

Current RogueMek version deployed: [v0.2.17](https://github.com/harbdog/roguemek/releases/tag/v0.2.17)

## Instructions
1. Go to the OpenShift application console:
https://openshift.redhat.com/app/console/applications

2. Create a new application

3. Select `Tomcat 7 (JBoss EWS 2.0)`

4. Choose a name for the application (for example, `roguemek`), which will become part of its Public URL (for example, `http://roguemek-yourdomain.rhcloud.com`)

5. Source Code: Enter the following as the URL to a Git repository (no branch/tag needed):
`https://github.com/harbdog/roguemek-openshift-quickstart`

6. This application doesn't yet support Scaling and all other defaults are fine.

7. Create Application, and wait. It will take about 5 minutes to fully start up the first time, even after the page says it was created.

8. You will want to immediately Register your first user since it will be created as an administrator user.

## Customization
For quickstart customization information, the OpenShift `jbossews` cartridge documentation can be found at:
http://openshift.github.io/documentation/oo_cartridge_guide.html#tomcat
