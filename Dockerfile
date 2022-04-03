FROM mysql:5.7.4
ENV MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD}
ENV MYSQL_DATABASE=${MYSQL_DATABASE}
ENV MYSQL_USER=${MYSQL_USER}
ENV MYSQL_USER_PASSWORD=${MYSQL_USER_PASSWORD}

COPY ./config/my.conf /etc/mysql/my.cnf