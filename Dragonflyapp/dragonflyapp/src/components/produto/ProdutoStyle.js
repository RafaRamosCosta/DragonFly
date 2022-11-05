import styled from "styled-components";

export const DivProd = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 10px;
    margin: 40px;
    background-color: #0f521d;
    border-radius: 7px;
    .compra{
        text-align: center;
        border: none;

        background-color: #0c5c11;
        cursor: pointer;
        margin-top: 10px;
        padding: 10px;
        border-radius: 5px;
        color: #fff;
        width: 40%;
        transition: all 0.3s ease-in-out;
        :hover {
            background-color: #1c8d19;
            transform: scale(1.1);
        }
    }

`;
