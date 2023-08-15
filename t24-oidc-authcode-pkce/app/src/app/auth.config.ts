import {AuthConfig} from 'angular-oauth2-oidc';

export const authConfig: AuthConfig = {
  issuer: 'http://localhost:9100/realms/t24-oidc-authcode-pkce',
  redirectUri: window.location.origin,
  clientId: 'client-app',
  responseType: 'code',
  scope: 'customers:manage',
  strictDiscoveryDocumentValidation: true,
}
