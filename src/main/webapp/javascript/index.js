
let button = document.getElementById("button");
let candyText = document.getElementById("candyText");
button.onclick = getFavCandy;


async function getFavCandy(){
    try {
        const raw_response = await fetch(`http://localhost:8080/app/candies`);

        if(!raw_response.ok){
            throw new Error(raw_response.status)
        }

        console.log("Request was completed")        

        const json_data = await raw_response.json();

        console.log(json_data);
        
        console.log(json_data[0].candyName);
        console.log(json_data[0].shop.shopName);
        candyText.innerHTML = `${json_data[1].candyName} is the best candy from the ${json_data[1].shop.shopName} shop for $${json_data[1].price}`

        
    } catch (error) {
        alert("There is an error: " + error)
        
    }
};