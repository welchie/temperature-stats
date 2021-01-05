FROM welchie99/temperature-stats:1.1


#COPY files/application.properties ./config/application.properties


HEALTHCHECK --interval=1m --timeout=3s CMD wget --quiet --tries=1 --spider http://localhost:8080/hello/ || exit 1
