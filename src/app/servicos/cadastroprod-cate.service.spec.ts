import { TestBed } from '@angular/core/testing';

import { CadastroprodCateService } from './cadastroprod-cate.service';

describe('CadastroprodCateService', () => {
  let service: CadastroprodCateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CadastroprodCateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
