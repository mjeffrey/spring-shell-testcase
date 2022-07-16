# spring-shell-testcase
To demonstrate some regressions between 2.0.1.RELEASE and 2.1.0-RC1

## Running with spring-shell 2.1.0
```
./mvnw  -Dspring-shell.version=2.1.0-RC1  spring-boot:run
```
## Running with spring-shell 2.0.1
```
./mvnw  -Dspring-shell.version=2.0.1.RELEASE  spring-boot:run
```

## Change of naming in shell options
For this shell option:
`@ShellOption boolean withBalance`

In 2.0.1 the option names were kebab case so this option was `--with-balance`

In 2.1.0-RC1 this is now camel case: `--withBalance`

Everyone can workaround this by setting the value explicitly e.g. `@ShellOption("--with-balance")`.

## ShellOption booleans are now mandatory
@ShellOption boolean withBalance

In 2.0.1 this option was optional (and set to false if not supplied)
```
shell:>account
iban=null, with-balance=false
```
```
shell:>account --with-balance
iban=null, with-balance=true
```

In 2.1.0-RC1 this is mandatory, so you need to write: `--withBalance false`
```
shell:>account
Missing option, longnames='withBalance', shortnames=''
```
