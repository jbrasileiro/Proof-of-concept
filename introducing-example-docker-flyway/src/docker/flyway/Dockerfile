FROM dhoer/flyway:alpine
COPY ./sql/*.sql /flyway/sql
VOLUME ./wait-for-it.sh:/usr/local/bin/wait-for-it.sh
ADD ./wait-for-it.sh /
RUN chmod 777 /wait-for-it.sh 