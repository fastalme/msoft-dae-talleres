import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { OAuthModule } from 'angular-oauth2-oidc';

import { AppComponent } from './app.component';

@NgModule({ declarations: [
        AppComponent
    ],
    bootstrap: [AppComponent], imports: [BrowserModule,
        OAuthModule.forRoot({
            resourceServer: {
                allowedUrls: ['http://localhost:8080'],
                sendAccessToken: true
            }
        })], providers: [provideHttpClient(withInterceptorsFromDi())] })

export class AppModule { }
