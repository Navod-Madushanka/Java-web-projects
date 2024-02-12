const baseUrl = "/nmshop/"

function secureFetch(url, options = {}) {
    const token = localStorage.getItem("accessToken");
    const expireIn = localStorage.getItem("expireIn");

    const expireAt = new Date(Number(expireIn)).getTime();
    const expireGate = new Date().getTime() + 2 * 60 * 1000;

    if (token && expireAt && expireAt < expireGate) {
        return refreshToken().then(newToken => {
            options.headers = {
                ...options.headers,
                Authorization: 'Bearer ' + newToken
            }

            return fetch(url, options);
        })
    }

    if (token) {
        options.headers = {
            ...options.headers,
            Authorization: 'Bearer ' + token
        }
    } else {
        console.log("Token Unavailable");
        window.location.href = `${baseUrl}login`;
    }
    return fetch(url, options);
}

function refreshToken() {
    const oldRefreshToken = localStorage.getItem("refreshToken");
    const userType = localStorage.getItem('userType');

    const fromData = new URLSearchParams();
    fromData.append('token', oldRefreshToken);
    fromData.append('userType',userType);

    if (oldRefreshToken) {
        return fetch(`${baseUrl}login/refresh-token`, {
            method: 'post',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: fromData
        }).then(response => {
            if (!response.ok) {
                window.location.href = `${baseUrl}login`;
            }
            return response.json();
        }).then(data => {
            localStorage.setItem("accessToken", data.accessToken);
            localStorage.setItem("refreshToken", data.refreshToken);
            localStorage.setItem("expireIn", data.expireIn);
            return data.accessToken;
        });
    } else {
        localStorage.removeItem("accessToken");
        localStorage.removeItem("expireIn");
        window.location.href = `${baseUrl}login`;
    }

}

// Goto WishList
function gotoWishList(){
    // document.getElementById('whishlist').addEventListener('click', (evt)=>{
    // });
    secureFetch(`${baseUrl}api/v1/category`,{
        headers:{
            'Content-Type':'application/json'
        }
    }).then(response=> response.text())
        .then(data=>{
            console.log(data)
        })
}

function gotoAdminProductView(){
    // document.getElementById('adminProductViewAll').addEventListener('click', (evt)=>{
    // });
    secureFetch(`${baseUrl}admin/product/add`,{
        headers:{
            'Content-Type':'application/json'
        }
    }).then(response=> response.text())
        .then(data=>{
            console.log(data)
        })
}


