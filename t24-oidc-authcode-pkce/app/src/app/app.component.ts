import { Component, OnDestroy } from '@angular/core';
import {OAuthService} from "angular-oauth2-oidc";
import {authConfig} from "./auth.config";
import {AppService} from "./app.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  text = '';
  customers :any;
  helloSubscription: Subscription;
  customersSubscription: Subscription;

  constructor(private oauthService: OAuthService, private appService: AppService) {
    this.configure();
    this.helloSubscription = appService.hello().subscribe(response => {
      this.text = response;
    });
    this.customersSubscription = appService.getAllCustomers().subscribe(response => {
      this.customers = JSON.parse(response);
      console.log(this.customers)
    });
  }

  ngOnDestroy(): void {
    this.helloSubscription.unsubscribe();
    this.customersSubscription.unsubscribe();
  }

  login() {
    this.oauthService.initCodeFlow();
  }

  private configure() {
    this.oauthService.configure(authConfig);
    this.oauthService.setupAutomaticSilentRefresh();
    this.oauthService.loadDiscoveryDocumentAndTryLogin().then(r => {if (!r) console.error("Error trying to login") });
  }

  logout() {
    this.oauthService.logOut();
  }

}
