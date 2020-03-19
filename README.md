# servicioEjemplo 1
## Dev Container con Visual Studio Code

Pre-Requisitos:
- Instalar [Docker](https://www.docker.com/products/docker-desktop).
- Instalar [Visual Studio Code](https://code.visualstudio.com/).
- Instalar extensión [Remote Development](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.vscode-remote-extensionpack) o por lo menos [Remote Container](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers).

Para iniciar el contenedor solo hay que seguir los siguientes pasos:

1. Descargar el proyecto a un directorio local.
2. Abrir el proyecto desde VS Code.
3. Presionar las teclas `Ctrl + P`:  
   3.1. Ingresar: `>Remote Containers`  
   3.2. Seleccionar: `Open Folder in Container`  
   *Se comenzará a crear el contenedor y se cambiará la vista a `Dev Container` lo cual puede tardar un poco al inicio*.  
4. Al terminar, verificar en la esquina inferior izquierda que esté activado en verde el botón `>< Dev Container`.
5. Posteriormente podemos verificar que las extensiones (`Ctrl + Shift + X`) de nuestro `Dev Container` se encuentren instaladas y activadas.
