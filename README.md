# pfpls 

(**UNDER DEVELOPMENT**)

Testing Primefaces comes with a lot of issues.
This project's goal is to tinker around with some of the available tools, to reduce flake tests.

## Overview

The project tries to tinker around with:
- implicit ajax and primefaces waits
- wrapper classes for some complex components
- mitigating some rare stale element reference exceptions not handled by Selenide's `$$`

## Getting Started

### Build & Verify

To build and run the tests, cd into the project's root, then do maven verify.

```bash
mvn clean verify
```

*(You'll be running with `headless=true` and `holdBrowserOpen=false`)*

By default maven uses a profile which runs a headless browser.

### Manually running tests from the IDE

If you're using IDEA, then:
- deselect `headless-during-verify` maven profile
- select `manually-in-ide* profile` maven profile
- reload all maven projects

IDEA should be able to pickup surefire's system variables.

*(You'll be running with `headless=false` and `holdBrowserOpen=true`)*

Currently the project uses `spring-boot` but this can change.
The end goal is to create a *clean lab environment*, where:

- you have 100% control over Primefaces view beans and markup files (e.g. xhtml)
- you can test issues in isolation
- you can cleanly dissect a complex issue
- the setup is relatively easy (e.g. no wildlfly)