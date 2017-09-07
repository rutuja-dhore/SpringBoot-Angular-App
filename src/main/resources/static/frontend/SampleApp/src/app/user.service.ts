import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { Http, RequestOptions, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { UserDTO } from './dtos/userDTO';
import { UserInDTO } from './dtos/userInDTO';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {

  private basePath: string = environment.API_BASE_PATH + '/users';
  private options: RequestOptions;

  constructor(
    private http: Http
  ) { }

  setRequestOptionsForSave() {
    this.options = new RequestOptions({ headers: new Headers({ 'Content-Type': 'application/json' }) });
  }

  findAll(): Observable<UserDTO[]> {
    return this.http.get(this.basePath).map(response => response.json() || {});
  }

  findOne(username: string): Observable<UserDTO> {
    return this.http.get(this.basePath + `/${username}`).map(response => response.json() || {});
  }

  save(userInDTO: UserInDTO): Observable<UserDTO> {
    this.setRequestOptionsForSave();
    return this.http.post(this.basePath, JSON.stringify(userInDTO), this.options).map(response => response.json() || {});
  }

  update(username: string, ifMatchValue: number, userInDTO: UserInDTO): Observable<UserDTO> {
    this.setRequestOptionsForSave();
    this.options.headers.append('If-Match', ifMatchValue.toString());
    return this.http.put(this.basePath + `/${username}`, JSON.stringify(userInDTO), this.options).map(response => response.json() || {});
  }
}
