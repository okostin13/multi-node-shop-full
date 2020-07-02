####For runnig this system with multiple instances of similar service use the next commands
```bash
docker-compose up -d config-service
```
>NOTE: Wait some time until the config-service starts full work
```bash
docker-compose up -d --scale order-service=3 --scale product-service=3
```
>NOTE: Installed `docker` and `docker-compose` required