Instrucciones de como usar el subversion con eclipse.

# Introduction #

Aca pongo las instrucciones para:

  1. Introduccion de que es un repositorio de subversion.
  1. Como instalar el cliente de svn (subclipse) en eclipse necesario para usar subversion.
  1. Como hacer el checkout inicial de todo el codigo del repositorio.
  1. Como hacer las operaciones basicas para interactuar con el repositorio ( update, commit, revert, syncronize)

# Details #

> ## 1) Introduccion de que es un repositorio de subversion. ##

Bueno basicamente es un servidor que alberga todo el codigo fuente de los proyectos subidos (commiteados) al igual que sus carpetas y archivos necesarios que permite que muchas personas puedan tener un lugar centralizado donde guardar sus programas.

Pero no es solo un repositorio, tiene mas inteligencia que un simple lugar fisico centralizado de informacion, tambien hace versionado, es decir, que cada vez que un commiter ( persona autorizada para hacer commit ) hace un commit ( valga la redundancia) se registra quien, cuando y qué hizo. Todos lo commiteado queda guardado y se genera un nuevo build. Un build es simplemente un numero que se va incrementando cada vez que hay un commit, cuando se genera el repositorio por primera vez el build es 1 y luego el subversion determina cuantos numeros incrementar en cada commit. Esto permite que si hay un problema luego de hacer un commit se pueda hacer un revert y volver a un build anterior al igual que se pueden ver los cambios hechos en cada commit.

Es importante saber que subversion tiene una cierta estructura de directorios que se genera cuando se crea el repositorio, basicamente hay 3 carpetas:

Branch: Aqui se ponen componentes extra o temporales como las versiones Beta.
Tag: Aqui se "congelan" las versiones, pudiendo mantener las versiones del software, por lo general no se hacen cambios aca, porque aca se ponen las versiones que luego son entregadas a los clientes y no se quiere afectar eso.
Trunk: Aqui se pone la ultima version del software y la que siempre se esta trabajando. Aca es donde se commitean los cambios. Cuando se llega a una version final se congela la version y se pasa a Tag.

Para mas info ir a: http://subclipse.tigris.org/wiki/JavaHL

> ## 2) Como instalar el cliente de svn ( subclipse) ##

  1. Abrir el eclipse.
  1. Ir a Preferencias >> Instalacion/Update >> Sitios de Software Disponible.
  1. Desactivar todos, luego apretar agregar/add.
  1. En nombre poner svn y en location poner http://subclipse.tigris.org/update_1.2.x >> apretar ok.
  1. Ir a Ayuda >> instalar software nuevo >> seleccionar el link agregado en el paso 4.
  1. Esperar a que carge el software >> seleccionar Subclipse Plugin v1.2.4 >> next, accept, finish.
  1. Si pregunta de restartear eclipse, poner que si.

> ## 3) Como hacer el checkout inicial de todo el codigo del repositorio. ##

Una vez haber hecho el paso 2) exitosamente, pueden hacer el checkout inicial de todo el proyecto. Para esto hay que hacer lo siguiente:

  1. Ir a eclipse y buscar en la parte superior derecha las perspectivas de eclipse. Buscar un icono que parece una            ventana con un + para agregar una perspectiva y agregar una que es un cilindo que dice SVN.
  1. Una vez alli, en el panel izquierdo presionar boton derecho >> New >> Repository Location.
  1. En la url poner: https://aplicaciones-distribuidas-luno.googlecode.com/svn/trunk/     >> Finish.
  1. Ahora deberian tener el repositorio ahi con esa direccion. Para hacer el checkout le hacen click derecho >> checkout.
  1. Seleccionar checkout as a project in the workspace y ponerle un nombre ( el que quieran) >> next.
  1. Les pide la direccion de su maquina donde guardarlo, pueden poner la default o la que quieran.
  1. Finish. Tardaria un ratito en bajar todo y ya deberian poder ver el código. Creo que no deberian tener los projectos todavia ( Si van a la perspectiva de Java ).

  1. Para esto deberian ir al Package Explorer o Project explorer o desde File >> import >> General >> Existing projects in the workspace.
  1. Seleccionan la carpeta donde hicieron el checkout y les deberia devolver todos los projectos del repositorio, ponen Finish y listo tienen todos ahi.


> ## 4) Como hacer las operaciones basicas para interactuar con el repositorio. ##

1. Hecho el paso 3) correctamente deberian tener los projectos importados mirando el project o package explorer. Van a notar que tiene una direccion de carpeta a la derecha (trunk/...) y ademas esos projectos tienen un cilindro representando una Base de datos. ( Van a ver otros cambios en el icono ya que estos son projectos importados de un repo).

2. Muy contentos y alegres van a ir a alguna clase y cambiar algo del codigo y luego salvarlo. Luego ven el icono de esa clase que cambiaron y ven que tiene un asterisco negro (WTF?). No se preocupen, es normal. Este asterisco negro solo indica que USTEDES tienen una diferencia con lo ULTIMO QUE ACTUALIZARON DEL REPOSITORIO. Quiero aclarar y esto es importante que el plugin de subclipse no actualiza automaticamente los cambios que se realizan, es decir, si yo hice hoy checkout y la semana que viene entro de nuevo y otra persona hizo commit y cambio cosas, yo NO VOY A TENER ESOS CAMBIOS, a menos que haga un UPDATE manualmente.
Nota: Una recomendacion para todos es que cada vez que se sienten a querer cambiar codigo hagan un UPDATE  de todos los projectos. Esto es muy simple. Seleccionan los projectos del repositorio que tienen en eclipse, le dan boton derecho >> Team >> Update.

3. Bueno, ya sabemos como updatear los cambios que otros realizaron en el repo y poder tener esa ultima version. Ahora, como hago yo para subir mis cambios, osea, commitear? Bueno la verdad es que hay 2 formas, PERO yo recomiendo usar solo 1 para evitar.

La primera es.... SI, como lo pensaron, hacer boton derecho en las clases que cambiaron >> Team >> Commit. ESTA FORMA YO NO LA RECOMIENDO, porque? Por lo siguiente: que pasa si yo hago update para asegurarme de tener la ultima version, hago cambios en una clase. Mientras estoy haciendo cambios, otra persona en otra pc hizo lo mismo, update, cambios, pero commiteo primero que yo. Luego yo muy contento sabiendo que tengo la ultima version le doy commit y puede pasar que le pise los cambios al otro ( SVN creo que es mas inteligente y evita esto, diciendote que hay un conflicto).

La segunda forma es mas elegante, usando el syncronize. Quiero aclarar que al apretar syncronize no se esta haciendo ningun cambio para nada en el repo. Lo que hace el syncronize es ir al repo y sacar la ultima version de lo que seleccionaron y compararlo para saber si hay conflictos o cambios. Se abre una perspectiva muy linda de Syncronizacion y les muestra cada clase con algunos iconitos.

Hay 4 iconos que paso a explicar:

- Flecha negra hacia la derecha: Esto significa que ustedes hicieron cambios en una clase y querrian actualizarla. ( No hay problema )

- Flecha hacia la derecha con un +: Esto significa que esa clase no existe en el repo y querrian agregarla. ( No hay problema).

- Flecha azul hacia la izquierda: Esto significa que ustedes no tienen la ultima version de esa clase y tienen que actualizarla, pero tambien significa que ustedes no hicieron cambios en ella. ( No hay problema, la seleccionan le dan update y joya).

- Flecha azul hacia la izquierda con un +: Ustedes no tienen la clase y tienen que agregarla a su eclipse ( No hay problema, update y ya).

- FLECHA ROJA HACIA BIDIRECCIONAL: Esto significa que hay un conflicto, alguien hizo un cambio, ustedes tambien y ahora el svn no sabe cual dejar, el de ustedes o el del otro. Este es el peor escenario, porque hay que hacer lo que se llama un Merge y es SIEMPRE MANUAL. Por suerte el subclipse plugin nos da una herramienta muy copada para hacer el merge.


Como hacer el Merge:

Bueno basicamente le dan doble click a la clase que tiene la flechita roja bidireccional y en esa perspectiva les van a aparecer 2 paneles a la derecha que parecen ser 2 ventanitas de la misma clase ( aunque no lo es).
A la izquierda tienen SU clase con SUS cambios y a la derecha tienen ultima version de esa clase del repo. Tienen que ir viendo los cambios y diferencias, si no hay conflictos con sus cambios los dejan ( Es decir, si yo cambie el metodo pirulo() y en el repo se cambio solo el metodo pirulin() no hay conflicto, entonces mis cambios no tendrian problema).

4. Bueno y me queda solo una cosita el revert. Esto pocas veces lo van a usar, a no ser que nos mandemos cagadas. Esto sirve para regresar la version de lo que elijan (clase, paquete o projecto) a una version anterior. En la perspectiva de Syncronizacion que les dije antes tendrian que tener una tab que se llama History de cada clase. Hay les va a mostrar en que builds se le hicieron cambios a una cierta clase y si seleccionan una anterior le pueden dar Revert para que vuelva a esa version.


Bueno eso es todo, OJALA, porque me dio una paja escribir todo esto, jaja.

Lo unico que pido es que lo lean y si tengan dudas avisenme. Pueden dejar comentarios aca abajo tambien, creo.

Saludos y nos vemos en clase!