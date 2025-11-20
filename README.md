# DevSecOps Demo – Java + GitHub Actions

Este proyecto es una aplicación Java de ejemplo diseñada para demostrar un pipeline completo de DevSecOps utilizando GitHub Actions, integrando:

- GitFlow automatizado
- Validación de nombres de ramas
- Validación de mensajes de commit
- CI (Build + Tests + Checkstyle)
- CD (Release + Deployment)
- Versionamiento Semántico automático
- Dependabot
- Linting y calidad de código

## Estructura del proyecto
```
devsecops_demo/
├── demo/                     # App Java (Maven)
│   ├── pom.xml
│   ├── src/
│   └── config/checkstyle/
├── commitlint.config.js     # Regla de mensajes de commit
└── .github/workflows/       # Todos los pipelines CI/CD
```

## GitHub Actions Incluidos

### 1. gitflow_branch_names.yml

Valida los nombres de las ramas siguiendo el estándar GitFlow:

| Tipo     |  Ejemplo |
|----------|----------|
|feature|feature-login-ui |
| bugfix |	bugfix-null-pointer |
| hotfix |	hotfix-prod-error |
| release | release-1.2.0 |

### 2. gitflow_pr_rules.yml

Controla hacia dónde se permiten PR, por ejemplo:

```
feature-* → solo a develop

bugfix-* → solo a develop

hotfix-* → solo a main

release-* → solo a main

develop → solo a main
```

Si el PR viola el flujo GitFlow, el Action falla.

### 3. CI – ci.yml

Incluye:

- Checkout
- Setup de JDK
- Compilación con Maven
- Ejecución de tests
- Checkstyle para validar estilo Java

### 🚢 4. CD – cd.yml

Ejemplo de pipeline de despliegue para ambientes (dev/staging/prod).

✔️ Se activa cuando hay tags o merges sobre main.

### 5. semver.yml

Genera versiones automáticas según:
```
feat: → minor
fix: → patch
BREAKING CHANGE → major
```

### 6. commit.yml

Valida mensajes de commit utilizando commitlint y tu expresión regular:
```
(?ms)^(?:(?:((?:AB#[0-9]{1,6}(?:,\s?AB#[0-9]{1,6}\s?)*))\-\s?)?(feat|fix|style|build|ci|refactor|test|doc|revert)(?:\b\(([^)]{0,10})\))?:\s?(.{5,60}))$
```


Esto fuerza commits como:

```
AB#1234-feat(api): agrega endpoint de usuarios
fix(ui): corrige bug de scroll
```

### 7. Dependabot

Actualiza dependencias de:

- Maven
- GitHub Actions
- NPM (para commitlint)

### Construcción de la aplicación

Ejecutar localmente:

```
cd demo
mvn clean install
```

Correr la app:

```
mvn exec:java -Dexec.mainClass="com.example.devsecops.App"
```

### 🧾 Mensajes de commit válidos

Ejemplos correctos:

|Tipo|Ejemplo|
|----|-------|
|feat|feat(api): agrega login|
|fix|fix(core): corrige NPE|
|feat + AB#|AB#123-feat(ui): agrega botón|

### Flujo GitFlow soportado
```
main
└── develop
    ├── feature/*
    ├── bugfix/*
    └── release/*
hotfix/*
```

### Releases automáticos

- Al mergear release-* o etiquetas sobre main:
- Se genera versión semántica
- Se publica artefacto (si está configurado)
- Se activa CD (deploy)

### Seguridad incorporada

- Commitlint → evita commits inseguros/inconsistentes
- Dependabot → evita dependencias vulnerables
- Checkstyle → evita malas prácticas Java
- Branch & PR rules → protegen el flujo GitFlow

SemVer → evita versiones manuales propensas a error