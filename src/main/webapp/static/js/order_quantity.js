//const quantity = document.querySelectorAll('.quantity');
/*
function increase(clickEvent){
    let counter = parseInt(clickEvent.currentTarget.nextSibling.innerText);
    counter += 1;
    clickEvent.currentTarget.nextSibling.innerText = counter;

    //let productId = clickEvent.currentTarget.dataset.superheroId;
    let quantity = clickEvent.currentTarget.nextSibling.innerText;


    //apiPut('/api/order', productId, quantity);
}

function decrease(clickEvent){
    let counter = parseInt(clickEvent.currentTarget.previousSibling.innerText);
    if(counter !== 0) {
        counter -= 1;
    }else{
        counter = 0;
    }
    clickEvent.currentTarget.previousSibling.innerText = counter;

    //let productId = clickEvent.currentTarget.dataset.superheroId;
    let quantity = clickEvent.currentTarget.nextSibling.innerText;
    //apiPut('/api/order', productId, quantity);
}

function createButtons(){
    quantity.forEach(element => {
        const plusBtn = document.createElement("button");
        const minusBtn = document.createElement("button");
        const counterSpan = document.createElement("span");
        plusBtn.innerText = "+";
        minusBtn.innerText = "-";
        counterSpan.innerText = 0;

        plusBtn.dataset.superheroId = element.dataset.superheroId;
        minusBtn.dataset.superheroId = element.dataset.superheroId;
        counterSpan.dataset.superheroId = element.dataset.superheroId;

        plusBtn.addEventListener('click', increase);
        minusBtn.addEventListener('click', decrease);
        element.append(plusBtn, counterSpan, minusBtn);
    })
}



function init(){
    createButtons();
}
*/
//init();
