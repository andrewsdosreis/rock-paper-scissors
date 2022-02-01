FROM node:16-alpine as build

WORKDIR /usr/app

COPY package.json /usr/app/package.json
RUN npm install

COPY ./public /usr/app/public
COPY ./src /usr/app/src

RUN sed -i 's/http:\/\/localhost:8080/http:\/\/backend:8080/g' /usr/app/src/App.js
RUN npm run build

FROM nginx:1.16.0-alpine
COPY --from=build /usr/app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]