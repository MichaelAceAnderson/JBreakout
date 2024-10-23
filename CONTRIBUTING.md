# Contributing to JBreakout

All information related to contributing to the project can be found in this file. It is **mandatory** to read it before contributing to the project in order to follow the conventions and make the development process easier for everyone. Thank you for your understanding!

- [Contributing to JBreakout](#contributing-to-jbreakout)
	- [Getting the Project](#getting-the-project)
	- [Project Conventions](#project-conventions)
		- [Versioning](#versioning)
		- [Git](#git)
		- [Code](#code)
			- [Indentation](#indentation)
			- [Code Quality](#code-quality)
	- [Technical Design](#technical-design)
		- [Development Environment](#development-environment)
		- [Structure](#structure)

## Getting the Project

The project is hosted in an online repository. It is recommended to associate your SSH keys with your account to clone the project via SSH for security reasons, but it is also possible to clone it via HTTPS.

Navigate to the folder where you want to clone the project (after creating it):  
On Windows:

```bat
cd %userprofile%\Documents\Projects\JBreakout\
```

On Linux:

```bash
cd ~/projects/JBreakout/
```

Clone via SSH:  

```bash
git clone git@github.com:MichaelAceAnderson/JBreakout.git
```

Clone via HTTPS

```bash
git clone https://github.com/MichaelAceAnderson/JBreakout.git
```

## Project Conventions

### Versioning

This project adheres to [Semantic Versioning](https://semver.org/). The version number is composed of three parts: major, minor, and patch. The version number is incremented according to the following rules:

- Major: making all related apps in previous versions incompatible with the current version
- Minor: added functionality in a backwards-compatible manner
- Patch: backwards-compatible bug fixes

Generally, versions must be incremented according to the following rules:

- breaking change: +1.0.0
- new feature: +0.1.0
- bug fix: +0.0.1
- other (refactor, indentation, ...): +0.0.01

### Git

⚠️ **Warning**: Always test your code and try to remove errors/warnings before commiting and/or submitting a pull request.  

- Commits should clearly describe their content and remain short. The commit message should be in English and include both the type of commit and the scope of the changes. If the change is global or not related to a specific feature/place in the code, the scope is optionnal.  
  ⚠️If the changes are related to an issue, the scope **must** be the issue number.
  - [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/)
    - `feat(scope)`: new feature (e.g., *feat(#1): authentication*)
    - `fix(scope)`: bug fix (e.g., *fix(#2): fixed communication problem regarding login*)
    - `docs(scope)`: documentation (e.g., *docs(#3): updated README*)
    - `style(scope)`: changes that do not affect the code (spacing, formatting, etc.) (e.g., *style: fixed indentation*)
    - `refactor(scope)`: code changes that neither fix a bug nor add a feature (e.g., *refactor(#5): optimized code*)
    - `perf(scope)`: performance improvement (e.g., *perf(#6): improved speed*)
    - `test(scope)`: adding or modifying tests (e.g., *test(#7): added unit tests*)
    - `conf(scope)`: build configuration changes (e.g., *conf(#8): updated Dockerfile*)
    - `chore(scope)`: changes to the development environment or project organization (e.g., *chore(#9): updated .gitignore*)
- Every branch must be associated with one type of change (see below) and be created from the `develop` branch. Everytime you finish changes on a branch, you must have it reviewed and merged back into `develop` so that the branch can be deleted and the changes can be integrated into the project. When enough features are ready, it is then possible to merge `develop` into `release/x.x.x` depending on the version number, then make small changes on the release branch in case of bugs, and finally merge the release branch into `main` to deploy the changes.
  - [Gitflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow)
    - `feat/xxxx-name-of-the-feature`: New feature referenced by the issue number and a short description (e.g., `feat/1-authentication`)
    - `fix/xxxx-name-of-the-fix`: Bug fix referenced by the issue number and a short description (e.g., `fix/2-login-error`)
    - `docs/xxxx-name-of-the-docs`: Documentation referenced by the issue number and a short description (e.g., `docs/3-readme`)
    - `style/xxxx-name-of-the-style`: Style changes referenced by the issue number and a short description (e.g., `style/4-indentation`)
    - `refactor/xxxx-name-of-the-refactor`: Refactoring referenced by the issue number and a short description (e.g., `refactor/5-optimization`)
    - `perf/xxxx-name-of-the-perf`: Performance improvement referenced by the issue number and a short description (e.g., `perf/6-speed`)
    - `test/xxxx-name-of-the-test`: Test changes referenced by the issue number and a short description (e.g., `test/7-unit`)

### Code

#### Indentation

Indentation must be done with tabs and not spaces.  
Use the [Prettier](https://prettier.io/) code formatter to ensure consistent code style. [Prettier for VSCode](https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode)

#### Code Quality

- Use LF line endings
- Your code must be as modulable and easily reusable as possible. Separate your code into functions and classes as much as possible, avoid long functions and try to separate the data logic from the UI logic as much as possible.
- Files should be grouped into a folder hierarchy according to their role
- Your code must be as self-explanatory as possible. If you cannot find a way to make it so, comment "why" and not "how" you did it
- Explicitly name variables and functions (which should remain short) to avoid the need for comments
- File, folder, variable names, and code in general must be in English
- Comments must be in English
- Variables and functions must follow the conventions of their respective language
  - Java:
    - [Code Conventions for the Java Programming Language](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
    - camelCase for variables and functions
    - PascalCase for classes
    - SCREAMING_SNAKE_CASE for constants

## Technical Design

This project is designed to be easily extendable and support multiple games. It includes a graphical and informational debug mode, with parameters available in the [/src/common/DebugMode.java](src/common/Debug.java) class. These modes can be dynamically changed and are defined in the program's entry point (MainCanvas or DebugGL). Feel free to experiment with them to understand how the rendering works.

### Development Environment

For reference, here are the latest tested versions of the applications used for the project:

| Component     | Version     |
|---------------|-------------|
| Java          | 15.0.2      |

### Structure

The project is divided into several parts based on the roles of the code:

- [**display**](src/display/): contains classes for managing game rendering
  - [**engine**](src/display/engine/): contains classes for the rendering engine (objects, shapes...)
    - [**rules**](src/display/engine/rules/): contains classes for managing rendering engine rules
    - [**shapes**](src/display/engine/shapes/): contains classes for geometric shapes (square, triangle, etc.) used to construct volumes
      - [**rules**](src/display/engine/shapes/rules/): contains classes for managing shape construction rules
  - [**view**](src/display/view/): contains classes for managing game views
- [**game**](src/game/): contains classes for managing different game types
  - [**type**](src/game/type/): contains classes for different game types
    - [**breakout**](src/game/type/breakout/): contains classes for managing the JBreakout game
      - [**assets**](src/game/type/breakout/assets/): contains game assets
        - [**images**](src/game/type/breakout/assets/images/): contains image assets
          - [**entities**](src/game/type/breakout/assets/images/entities/): contains image assets for game entities
      - [**entities**](src/game/type/breakout/entities/): contains classes for managing game entities
        - [**type**](src/game/type/breakout/entities/type/): contains classes for different types of entities
