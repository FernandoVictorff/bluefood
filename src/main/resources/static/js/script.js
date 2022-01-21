function isNumberKey(e) {
    return Number.isInteger(parseInt(e.key, 10)) 
	|| e.key === 'Delete'
	|| e.key === 'Backspace'
	|| e.key === 'ArrowLeft'
	|| e.key === 'ArrowRight'
}