# Download Jellyfin Easy Metadata Manager#

## How to download a Runnable version of JEMM ? ##
🚀 Not a Developer? No Problem!

If you're not into coding or just want to skip the hassle of building JEMM from source, we've got you covered! You can directly download the ready-to-run file:

[jemm_runnable-jar-with-dependencies.jar](https://github.com/CesarBianchi/JellyfinEasyMetadataManager/blob/main/target/jemm_runnable-jar-with-dependencies.jar)

To run it smoothly, make sure:

- 🧩 You have Java 11 installed on your machine.
- 🔑 You’ve generated an API Key from your Jellyfin instance. [Check the doc about Jellyfin API Key](/about/requirements/#jellyfin-api-key)
- 🛠️ Having trouble? Before diving into fixes, make sure to check the [Requirements Page](/about/requirements/) It covers everything JEMM needs to run smoothly and can help resolve common setup issues quickly.

Once you’ve got those two things, you’re all set to launch JEMM and start exploring!

## To download source-code and build JEMM Locally ##

🛠️ If you're a developer, you can clone the JEMM project using your favorite Git client:

    git clone https://github.com/CesarBianchi/JellyfinEasyMetadataManager.git

JEMM was originally built using Apache NetBeans IDE 19 and Java 11, but feel free to use any IDE you're comfortable with — like IntelliJ IDEA, Eclipse, or VS Code.

Once cloned:

- Import the project into your IDE as a Maven project.
- Make sure Java 11 is set as your runtime environment.
- Build the project using Maven (mvn clean install) to generate the runnable .jar file.
- Run JEMM using the generated jemm_runnable-jar-with-dependencies.jar located in root/target/.

Happy coding! 💻