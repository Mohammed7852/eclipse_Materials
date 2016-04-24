CREATE TABLE [dbo].[ProductDimension] (
    [ProductID]              INT           NOT NULL,
    [ProductName]            NVARCHAR (50) NOT NULL,
    [ProductSubcategoryName] NVARCHAR (50) NOT NULL,
    [CategoryName]           NVARCHAR (50) NOT NULL,
    CONSTRAINT [PK_ProductDimension] PRIMARY KEY CLUSTERED ([ProductID] ASC)
);

