# ⏳ Processing Time – What to Expect#

Every operation in JEMM — whether login process, generating reports, exporting metadata, or applying bulk changes — requires communication with your Jellyfin server. Because of this, processing time may vary depending on several factors:

- 📚 *Size of your Jellyfin instance (number of libraries and items)*
- ⚙️ *Performance of the Jellyfin server and its APIs*
- 🖥️ *Hardware resources behind the Jellyfin server (CPU, memory, disk speed)*
- 🌐 *Network latency between JEMM and the Jellyfin server*
- 🔄 *Complexity of the requested operation*

**These variables mean that some tasks may complete in seconds, while others — especially on large setups — may take longer.**

To keep the experience smooth and transparent, JEMM displays a friendly wait window during processing. This lets you know the system is working and helps prevent interruptions while your request is being handled.

![Here's an example of JEMM Message Wait Window](https://github.com/CesarBianchi/JellyfinEasyMetadataManager/blob/main/mkdocs/jemmdocs/docs/images/waitWindow.png?raw=true)