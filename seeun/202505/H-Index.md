# H-Index

📌 **문제 링크**  
[프로그래머스 - H-Index](https://school.programmers.co.kr/learn/courses/30/lessons/42747)

---

## 📍 문제 접근  
- h번 이상 인용된 h편의 논문의 최대값을 찾기 위해 내림차순으로 정렬해 순회하여 푼다.

---

## ⏳ 수행 시간  
- 20분

---

## ✅ 테스트 인증  
![image](https://github.com/user-attachments/assets/1dc6b5b3-6444-4fd1-a266-6cb329928220)
![image](https://github.com/user-attachments/assets/fe8ee080-0319-4c87-aad3-94660a0e1db7)


---

## ⏰ 시간 복잡도  
- O(n log n)

---

## 🧑‍💻 코드 (JavaScript)

```javascript
function solution(citations) {

    citations.sort((a, b) => b - a); // 가장 많이 인용된 순으로 내림차순으로 정렬
    
    let hIndex = 0;
    
    for (let i = 0; i < citations.length; i++) {
        const h = i + 1;  // 현재까지 본 논문 수
        
        if (citations[i] >= h) {
            hIndex = h;
        } else {
            break;
        }
    }
    return hIndex;
}
```   
