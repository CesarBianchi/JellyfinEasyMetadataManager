# Getting Started with JEMM: Minimal Requirements

## Java Version
To run JEMM, your machine must have **Java version 11 or later installed**.

If Java is not already installed, follow these steps to download and install it:

1. Visit the [Official Java website](https://www.oracle.com/java/technologies/downloads/)

2. Download the Java SE Development Kit (JDK) 
    Choose the version that matches your operating system (Windows, macOS, or Linux) and download the installer for Java 11 or later.

3. Run the installer 
    Open the downloaded file and follow the on-screen instructions to complete the installation.

4. Verify the installation
    After installation, open a terminal or command prompt and type: **java -version**



## Operational System
🖥️ Operating System Requirements

JEMM is compatible with any operating system that supports Java version 11 or later. This includes, but is not limited to:

- Windows (Windows 10, Windows 11, and newer versions)
- macOS (macOS 10.14 Mojave and later)
- Linux (Ubuntu, Fedora, Debian, CentOS, and other major distributions)
- Other Unix-based systems with Java support

To ensure compatibility, verify that your operating system can run Java applications and that Java version 11 or later is properly installed. For installation instructions, check "Java Version" options in this page.


## Jellyfin API Key
🔑 A Jellyfin API Key is a secure token that allows external applications —like JEMM— to communicate with your Jellyfin media server. It grants access to specific features and data without requiring your username and password, helping maintain security while enabling integration.

### How to Generate a Jellyfin API Key

To create a new API Key in Jellyfin, follow these steps:

1. Log in to your Jellyfin Server, open your Jellyfin web interface and sign in with an administrator account.

2. Access the Dashboard Click on your profile icon in the top-right corner and select Dashboard.

3. Navigate to API Keys In the left-hand menu, go to Advanced > API Keys.

4. Create a New Key Click the + Add API Key button.

    Optionally, give your key a name (e.g., “JEMM Integration”)

    Set expiration date or permissions if needed

5. Copy the Key Once generated, copy the API Key and store it securely. ⚠️ You won’t be able to view it again after closing the dialog.

6. Use the Key in JEMM Paste the API Key into the appropriate field in JEMM’s configuration or settings panel to enable Jellyfin integration.

## Are you a Developer ?
👨‍💻 JEMM was developed using NetBeans 11 and is fully open-source. The complete source code is available on [GitHub](https://github.com/CesarBianchi/JellyfinEasyMetadataManager)

Developers are welcome to explore, contribute, or fork the project. If you encounter any bugs or unexpected behavior, please report them through the GitHub Issues page.

### 🐞 How to Report a Bug

When submitting a bug report, include as much relevant information as possible to help with diagnosis and resolution:

- ✅ JEMM version you are using
- ✅ Jellyfin Instance Server version connected to JEMM
- ✅ Operating system and environment details
- ✅ Error logs or stack traces
- ✅ Screenshots or screen recordings (if applicable)
- ✅ Steps to reproduce the issue