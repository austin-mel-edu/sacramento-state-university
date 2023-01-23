(define (inc_n n)
  (lambda (x)
    (+ n x)))

(define len
  (lambda (ls)
    (define length1
      (lambda (ls n)
        (if (null? ls) n
            (length1 (cdr ls)(+ n 1)))))
    (length1 ls 0)))

(define (maxmin ls)
  (define (min a b) (if (< a b) a b))
  (define (max a b) (if (> a b) a b))
  (let loop ((x -inf.0) (y +inf.0) (ls ls))
    (if (null? ls)
        (list x y)
        (loop (max (car ls) x) (min (car ls) y) (cdr ls)))))

(define mem
  (lambda (x ls)
    (cond ((null? ls) #f)
        (else(if(eq? x (car ls)) #t
           (mem x (cdr ls)))))))

(define ins
  (lambda (x ls)
    (cond ((null? ls) ls)
          (else(if(mem x ls) ls
             (append ls x))))))

(define numT
  (lambda (bool ls)
    (define numTCnt
      (lambda (ls n)
        (cond ((null? ls) n)
              (else(if(bool(car ls)) (numTCnt(cdr ls)(+ n 1))
                      (numTCnt(cdr ls)n))))))
    (numTCnt ls 0)))

(define moreT
  (lambda (bool ls1 ls2)
    (define x (numT bool ls1))
    (define y (numT bool ls2))
    (cond ((> x y) 1)
          ((< x y) 2)
          ((= x y) 0))))


; GIVEN TESTS
((inc_n 3) 2) ;returns 5
(len '(2 1)) ;returns 2
(maxmin '(4 2 -1 10)) ;returns (10 -1)
(mem '(1) '(1 4 -2)) ;returns #f
;(mem 1 '(1 4 -2)) ;returns #t
(ins '(5) '(2 10 -3)) ;returns (2 10 -3 5)
;(ins '(2) '(2 10 -3)) ;returns (2 10 -3)
(numT number? '(1 -5 -4 (2 1) 7)) ;returns 4
;(numT even? '(1 2 3 4 5)) ;returns 3
(moreT negative? '(8 -4 3 8) '(7 -3 -2 1 -5)) ;returns 2
;(moreT even? '(8 -4 3 8) '(6 3 2 1 -4)) ;returns 0