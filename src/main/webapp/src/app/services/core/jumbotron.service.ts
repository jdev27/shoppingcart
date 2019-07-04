import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Jumbotron } from '@app/model/core/jumbotron';

@Injectable({
  providedIn: 'root'
})
export class JumbotronService {

  private _url: string = "/assets/core/jumbotron.json";
  constructor(private http: HttpClient) { }


  getJumbotron(): Observable<Jumbotron> {
    return this.http.get<Jumbotron>(this._url);
  }
  errorHandler(error: HttpErrorResponse) {
    return Observable.throw(error.message || "Server Error");
  }
}
